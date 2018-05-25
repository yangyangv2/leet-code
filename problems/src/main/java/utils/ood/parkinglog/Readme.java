package utils.ood.parkinglog;

/*
Design a parking lot using object- oriented principles

https://github.com/gaylemcd/ctci/tree/master/java/Chapter%208/Question8_4

首先： 需要和面试官讨论把问题具体化， 例如 可停的汽车类型， 是否是多层的parking lot 等等。

然后做出如下假设

(1) multiple level, each level has multiple rows of spots

(2) can park motorcycles, cars and buses

(3) parking lot has motorcycle spots, compact spot, and large spot （注意停车位也分为了不同类型！！！）

(4) a motorcycle can park in any spot

(5) car park in single compact spot or large spot

(6) bus can park in five large spots that are consecutive and within same row. it can not park in small spots

然后可以开始设计


Part 1  Vehicle

枚举大小， Vehicle 设为abstract class

Part 2 Parking Lot
Parking Spot, no need to have classes for LargeSpot, CompactSpot and MotorcycleSpot inheriting from Parking Spot,
cause they do not have different behavior, only different size


最后完成整个parking Lot
可以看做是wrapper class for an array of levels

(or double array or hashtable(level, listofspot)

*/


public class Readme {
}
