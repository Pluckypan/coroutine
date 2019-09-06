package engineer.echo.coroutine

import kotlinx.coroutines.*
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @ObsoleteCoroutinesApi
    @Test
    fun firstCoroutine() {
        GlobalScope.launch {
            delay(3000)
            println("hello coroutine")
        }
        GlobalScope.launch(Dispatchers.Default) {
            println("background work.")
        }
        GlobalScope.launch(newSingleThreadContext("IO")) {
            println("background work.")
        }
        val job = GlobalScope.launch(context = newFixedThreadPoolContext(5, "compute"),
            start = CoroutineStart.LAZY, block = {

            })
        job.cancel()

        GlobalScope.launch {
            val result = async {
                calculate(250, 520)
            }
            println("result is ${result.await()}")
        }
    }

    /**
     * background work
     */
    private fun calculate(a: Int, b: Int) = (a + b).coerceAtMost(10000)
}
