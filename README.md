# MiniGeo

地理小工具

## 项目开发计划

- [x] Geo-fencing
- [ ] Min-rectangle
- [ ] R-tree

##使用

```java
public class App(){
    public static void main(String[] args){
        Point p = new Point(1.5, 1.5);
        Point[] v = new Point[4];
        v[0] = new Point(1, 1);
        v[1] = new Point(2, 1);
        v[2] = new Point(2, 2);
        v[3] = new Point(1, 2);
        Fence.isIn(p, new Polygon(v)); // true
    }
}
```
