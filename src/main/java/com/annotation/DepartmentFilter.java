package com.annotation;

import com.annotation.def.Column;
import com.annotation.def.Table;

@Table("t_department")
public class DepartmentFilter implements Filter{
    @Column("id")
    private int id;
    @Column("name")
    private String name;
    @Column("head")
    private String head;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }
}
