### 前言
### 关键字
- 协程是一个轻量级的线程

#### 如何体现轻量的
[协程很轻量](http://www.kotlincn.net/docs/reference/coroutines/basics.html#%E5%8D%8F%E7%A8%8B%E5%BE%88%E8%BD%BB%E9%87%8F)
```
import kotlinx.coroutines.*

fun main() = runBlocking {
    repeat(100_000) { // 启动大量的协程
        launch {
            delay(1000L)
            print(".")
        }
    }
}
```

#### 写法简单
```
GlobalScope.launch { 
        // 在后台启动一个新的协程并继续
        delay(1000L) // 非阻塞的等待 1 秒钟（默认时间单位是毫秒）
        println("World!") // 在延迟后打印输出
    }
```

#### 再也没有万恶的回调
```
```