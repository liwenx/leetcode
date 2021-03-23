package com.liwx.designpattern.singleton;


/**
 * @author liwenxing
 * @date 2018/2/14 10:31
 */

/**
 * 懒汉式单例
 *
 *
 *假如在某一瞬间线程A和线程B都在调用getInstance()方法，
 * 此时instance对象为null值，均能通过instance == null的判断。
 * 由于实现了synchronized加锁机制，线程A进入synchronized锁定的代码中执行实例创建代码，
 * 线程B处于排队等待状态，必须等待线程A执行完毕后才可以进入synchronized锁定代码。
 * 但当A执行完毕时，线程B并不知道实例已经创建，将继续创建新的实例，
 * 导致产生多个单例对象，违背单例模式的设计思想，因此需要进行进一步改进，
 * 在synchronized中再进行一次(instance == null)判断，
 * 这种方式称为
 *
 *
 * 双重检查锁定(Double-Check Locking)。
 *
 *
 * 为什么要使用volatile 修饰instance？

 主要在于instance = new Singleton()这句，这并非是一个原子操作，
 原子操作指的是不会被线程调度机制打断的操作；这种操作一旦开始，就一直运行到结束，中间不会有任何 context switch（切换到另一个线程）。
 事实上在 JVM 中这句话大概做了下面 3 件事情:

 1.给 instance 分配内存

 2.调用 Singleton 的构造函数来初始化成员变量

 3.将instance对象指向分配的内存空间（执行完这步 instance 就为非 null 了）。

 但是在 JVM 的即时编译器中存在指令重排序的优化。
 也就是说上面的第二步和第三步的顺序是不能保证的，最终的执行顺序可能是 1-2-3 也可能是 1-3-2。
 如果是后者，则在 3 执行完毕、2 未执行之前，被线程二抢占了，这时 instance 已经是非 null 了（但却没有初始化），
 所以线程二会直接返回 instance，然后使用，然后顺理成章地报错。


 (另一个博客的解释：使用volatile关键字防止重排序，因为 new Instance()是一个非原子操作，可能创建一个不完整的实例)
 http://blog.csdn.net/justloveyou_/article/details/64127789
 好的解释：
 我们需要重新考察上述清单中的 //3 行。
 此行代码创建了一个 Singleton 对象并初始化变量 instance 来引用此对象。
 这行代码存在的问题是，在 Singleton 构造函数体执行之前，
 变量 instance 可能提前成为非 null 的，即赋值语句在对象实例化之前调用，
 此时别的线程将得到的是一个不完整（未初始化）的对象，会导致系统崩溃。下面是程序可能的一组执行步骤：
 　　1、线程 1 进入 getInstance() 方法；
 　　2、由于 instance 为 null，线程 1 在 //1 处进入 synchronized 块；
 　　3、同样由于 instance 为 null，线程 1 直接前进到 //3 处，但在构造函数执行之前，使实例成为非 null，并且该实例是未初始化的；
 　　4、线程 1 被线程 2 预占；
 　　5、线程 2 检查实例是否为 null。因为实例不为 null，线程 2 得到一个不完整（未初始化）的 Singleton 对象；
 　　6、线程 2 被线程 1 预占。
 　　7、线程 1 通过运行 instance 对象的构造函数来完成对该对象的初始化。




 我们知道，当我们在程序中声明一个对象时，编译器为调用构造函数(如果有的话)，
 而这个调用将通常是外部的，也就是说它不属于class对象本身的调用，假如构造函数是私有的，
 由于在class外部不允许访问私有成员，所以这将导致编译出错。
 */
public class LazySingleton {
    private volatile static LazySingleton instance = null;

    private LazySingleton(){}

    public static LazySingleton getInstance(){
        //第一重判断
        if(instance == null) {                        // 1
            //锁定代码块
            synchronized (LazySingleton.class){
                //第二重判断
                if(instance == null){                 // 2
                    instance = new LazySingleton();   // 3
                }
            }
        }
        return instance;
    }
}
