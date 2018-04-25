## VIM使用技巧


 ### surround
    ysiw
    hcsiw
    dsiw
 ### 寄存器
    "*和"+ 都系统剪切板
    "0 复制专用寄存器
 ### 差用的插入模式的快捷键
    ctrl+h 删除光标左边字符
    ctrl+w 删除光标左边单词
    ctrl+y 复制上方的一个字符 
    ctrl+e 复制下方的一个字符
    ctrl+r 0 插入前一次用y命令寄存的内容
    ctrl+r * 插入系统剪切板的内容
    ctrl+a 插入前一次插入模式所键入的内容
    ctrl+c 执行一个普通模式下的命令然后返回插入模式
 ### 文本替换
    使用:s/正则表达式/替换文本/可在本行内替换首次出现的匹配
    使用:s/正则表达式/替换文本/g 在本行内替换所有出现的匹配
    使用:%s/正则表达式/替换文本/g 在当前文件内替换所有出现的匹配

 ### 代码折叠 
    zc 折叠
    zC 对所在范围内所有嵌套的折叠点进行折叠
    zo 展开折叠
    zO 对所在范围内所有嵌套的折叠点展开
    [z 到当前打开的折叠的开始处。
    ]z 到当前打开的折叠的末尾处。
    zj 向下移动。到达下一个折叠的开始处。关闭的折叠也被计入。
    zk 向上移动到前一折叠的结束处。关闭的折叠也被计入。
        
 ### 快速移动代码
    1. 简单移动
        hjkl
    2. 利用查找移动
    
        正向查找 /hello
        反向查找 ?hello
        
       实例：快速删除time到tutor之间的内容 /time回车，d/tutor  
            快速修改time到tutor之间的内容 /time回车， c/tutor 
           The approximate time required to complete the tutor is 25-30 minutes. 
     
    3. 行内快速移动，利用f命令搜索某个字符的方式
        fa 表示向前移动到a字符处
        Fa 表示向后移动到a字符处
        ta 表示向后移动到a字符前面
        Ta 
        ;表示重复上一次的查找命令，“，”会反方向查找前一次的查找命令
    4.使用w,b,e以word为单位进行移动
        2w表示向后移动2个word
        2b表示向前移动2个word
        2e表示向后移动2个word，但是会移动到word字符之后 
        ge表示移动光标到上一个单词结尾      
  
        如果想忽略标点符号的word,就使用大写
        W、B、E
    5.移动到行首、行尾（适合行内移动）
        ^表示移动到行首第一个word出，即行首有空格的情况，不会移动到空格之前。
        0表示移动到行首，有空格的情况，会移动到空格之前
        $表示移动到行末，行尾有空格的情况，会移动到空格之后
       如果想移动到行末最后一个非空白的字符处，就输入$b。 
    6. 利用行号跳转（适合大范围移动）
        :11 表示跳转到11行
       第m行到第n行右移一个tab 
       :m,n>
        
    7. 移动到文本开头和结尾
        gg表示跳转到文本的开头
        G表示跳转到文本的结尾
        H表示光标跳转到当前界面的最上面
        M表示光标跳转到当前界面的最中间
        L表示光标跳转到当前界面的最下面
        zz表示把光标所在行居中到屏幕中间
        75% 表示跳转到文档75%处
        
        ctrl + f表示向下翻页
        ctrl + b表示向上翻页
    8.利用标记mark命令
    ma 表示标记改行为a，
    'a 表示跳转到a处，会跳转到a的行首，单引号'
    `a 表示跳转到a处，会跳转到标记a的行，包括a的第几列。更精确。
        连续的多行的左右移动
            移动移动到要处理的首行，输入ma
            移动到要处理的尾行，输入<'a
    `. 跳转到之前修改位置
    `` 在前一次跳转有位置与当前位置切换
   
   ### 列操作
   
   li.   a{background-image: url('/components/sprrite.png') }
   li.two   a{background-image: url('/components/sprrite.png') }
   li.three a{background-image: url('/components/sprrite.png') }
   li.four  a{background-image: url('/components/sprrite.png') }

    hello world
   
    var foo 	| 1;
    -----------------------
    var foo 	| 1;
    var bar 	| 'a';
    var foobar 	| foo + bar ;
   
   1.One
   2.Two
   3.Three
   //break up the monotony
   4.Four
   5.Five
   6.Sex
   


