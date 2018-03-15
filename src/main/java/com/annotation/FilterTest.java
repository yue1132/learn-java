package com.annotation;

import com.annotation.def.Column;
import com.annotation.def.Table;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FilterTest {
    public static void main(String[] args) {

        UserFilter f1 = new UserFilter();
        f1.setId(10); //查询ID为10的用户

        UserFilter f2 = new UserFilter();
        f2.setUserName("lucy"); //查询用户名为lucy的用户
        f2.setCity("四川");

        UserFilter f3 = new UserFilter();
        f3.setEmail("liu@sina.com,zh@163.com,aaa@gmail.com");//查询邮箱为其中任意一个的用户

        String sql1 = query(f1);
        String sql2 = query(f2);
        String sql3 = query(f3);

        DepartmentFilter f4 = new DepartmentFilter();
        f4.setName("信息化中心");
        query(f4);

    }

    /**
     * 通过解析注解，拼接字符串
     *
     * @param filter
     * @return
     */
    private static String query(Filter filter) {
        //存储拼接的sql字符串
        StringBuilder sb = new StringBuilder();

        //1.获取class
        Class<? extends Filter> aClass = filter.getClass();

        //2.获取table的名字
        boolean isExitTable = aClass.isAnnotationPresent(Table.class);
        if (!isExitTable) {
            return "当前类UserFilter没有Table注解，请添加！";
        }
        Table table = aClass.getAnnotation(Table.class);
        String tableName = table.value();
        sb.append("select * from ").append(tableName).append(" where 1=1 ");

        //3.遍历所有的字段
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            //判断字段是否包含Column注解
            boolean isExistField = field.isAnnotationPresent(Column.class);
            if (!isExistField) {
                return "当前属性没有Column注解，请添加！";
            }
            Column column = field.getAnnotation(Column.class);
            //拿到字段的值
            String columnName = column.value();
            String fieldName = field.getName();
            //获取方法名
            String methodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);

            Object fieldValue = null;
            try {
                //调用方法获取字段的值
                Method method = aClass.getMethod(methodName);
                fieldValue = method.invoke(filter);

            } catch (Exception e) {
                e.printStackTrace();
            }

            //拼装sql
            if (fieldValue == null || fieldValue instanceof Integer && (Integer)fieldValue == 0) {
                continue;
            }
            sb.append(" and ").append(fieldName);
            if (fieldValue instanceof String) {
                if(((String) fieldValue).contains(",")){
                    String[] values = ((String) fieldValue).split(",");
                    sb.append(" in(");
                    for (String val : values) {
                        sb.append("'").append(val).append("',");
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    sb.append(")");
                } else{
                    sb.append("=").append("'").append(fieldValue).append("'");
                }
            } else if (fieldValue instanceof Integer){
                sb.append("=").append(fieldValue);
            }

        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
