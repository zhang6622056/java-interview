Java基础面试题
===

### 1-Java基础数据类型的大小（基础问题）

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




### 2-equals与==的区别?

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






