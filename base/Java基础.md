Java基础面试题
===

### 1.Java基础数据类型的大小（基础问题）

| 数据类型   |      最小值   |  最大值 |占位 | 
|----------|:-------------:|------:| ------:| 
| boolean | 0 | 1 |1bit|
| byte |  -128（-2^7） | 127（2^7-1）|8bit|
| short | -32768（-2^15） | 32767（2^15 - 1）|16bit|
| int | -2,147,483,648（-2^31） | 2,147,483,647（2^31 - 1）|32bit|
| long | -9,223,372,036,854,775,808（-2^63） | 9,223,372,036,854,775,807|64bit|
| float |  1.4E-45 | 3.4028235E38 |32bit|
| double |  4.9E-324  | 1.7976931348623157E308 |64bit|
| char |  -128（-2^7） | 127（2^7-1）|16bit|




### 2.equals与==的区别?

基本类型：在比较基本类型的时候，是内存中的值比较。而基本类型也没有eq方法，所以不用考虑

引用类型：从根本上来讲，最终都会到Object对象的eq方法。而eq方法是可以根据业务重写的。所以 ==和eq方法没有必然联系.
引用类型在使用==进行判定的时候，判定的是对象的内存地址是否相等。

重写eq方法，必须要重写hashcode方法。这是因为在散列的算法中，要应用对象的hashcode来散列相应的内存地址空间，eq来判定内存中是否已经存在了该对象key映射的值

基于jdk7提供的Objects的eq重写实例


    public class Question2 {
        private String username;
        private String pwd;
    
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Question2 question2 = (Question2) o;
            return Objects.equals(username, question2.username) &&
                    Objects.equals(pwd, question2.pwd);
        }
    
        @Override
        public int hashCode() {
            return Objects.hash(username, pwd);
        }
    }



### 3.简述Java的clone方法

- clone方法
所有的clone方法都指的是浅拷贝，所谓浅拷贝指的是user.clone只是user的一个备份。但是如果user内有其他引用类型属性的时候，这些属性与clone完成的对象是共享的。
也就是原对象的设置方法将会影响拷贝完成后备份的属性值

- 但是这里需要注意的是String与基本类型的包装类，它们原则上都是不可变的。也就是copyOnWrite的一种实现方式。所以这种类型的变量不会有什么影响

- 重写clone方法，必须显示调用super.clone

可参考案例:


    public class Question3 extends BaseQuestion3 implements Cloneable{
    
        private String username;
        private Integer password;
        private Computer computer;
        //此处省略setter getter
    
        public static void main(String[] args) throws CloneNotSupportedException {
            Question3 question3 = new Question3();
            question3.setComputer(new Computer());
            question3.setUsername("nero");
            Question3 questionAno = (Question3) question3.clone();
            questionAno.setUsername("dante");
    
            System.out.println(questionAno.getUsername());
            System.out.println(question3.getUsername());
    
            System.out.println(questionAno == question3);
            System.out.println(questionAno.getComputer() == question3.getComputer());
            System.out.println(questionAno.getUsername() == question3.getUsername());
            System.out.println(questionAno.getPassword() == question3.getPassword());
        }
    }


- 相信你已经发现，我们希望一个全新的类，省略set赋值的过程，这我们称之为深拷贝，那么如何进行深拷贝呢?
一个是Java序列化，另外一个则推荐使用BeanCopy来实现。相关实现有3,其中性能较高的是cglib的beancopy，原因可以自行搜索动态代理与反射原理

    - BeanCopy From Apache Util
    - BeanCopy from spring
    - BeanCopy from cglib


### 4.简述Java Object的equals方法

- code from jdk8

        public boolean equals(Object obj) {
            return (this == obj);
        }
        
   意指内存指向是否相同，不再过多追述



### 5.简述Java Object的hashcode方法
hashcode方法可以说是java为了散列表所做的一项技术，当然基本上所有的语言都会支撑以散列算法来实现o(1)的存取。
最简单的散列技术无非就是取余，它是空间换取时间的一种算法。

- 入门推荐：https://blog.csdn.net/zhang6622056/article/details/79380812

- 进阶推荐：
    
    - https://www.cnblogs.com/skywang12345/p/3311899.html
    - https://www.cnblogs.com/skywang12345/p/3311909.html
    - https://www.cnblogs.com/skywang12345/p/3311915.html




### 6.简述Java Object的finalize方法


finalize方法是Java gc过程中会调用的一个方法(前提是被回收对象的程序中重写了该方法)。
该方法严格意义上不建议在程序中显示的被调用，但是，如果显示调用了该方法，该方法也就是一个对象方法而已，没有什么特殊的含义
一般用于gc前的资源释放，比如mysql驱动中的如下代码，当对象被回收，我们进行链接的释放
    
    
	protected void finalize() throws Throwable {
		cleanup(null);
		
		super.finalize();
	}


- 进阶参考
    - https://bijian1013.iteye.com/blog/2288223
    - https://zhang-xzhi-xjtu.iteye.com/blog/484934
    










### 4.简述Java的4种引用类型
### 5.结合源码说明String、StringBuffer与StringBuilder的区别
### 6.结合字节码说明try catch finally的执行顺序
### 7.简述Java的异常处理? Exception和Error
### 8.简述反射，为什么反射性能差?






