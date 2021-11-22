package exception;

/**
 * @author Sun
 */
public class ThrowableAndException {
    /*
     * Throwable 常用方法
     *
     * 返回抛出异常的详细信息
     * public String getMessage();
     * public String getLocalizedMessage();
     *
     * 返回异常发生时的简要描述
     * public String toString();
     *
     * 打印异常信息到标准输出流上
     * public void printStackTrace();
     * public void printStackTrace(PrintStream s);
     * public void printStackTrace(PrintWriter s);
     *
     * 记录栈帧的当前状态
     * public synchronized Throwable fillInStackTrace();
     */

    /*
     * Exception extends Throwable
     * 分为 RuntimeException 和 CheckedException
     *
     * 1. RuntimeException 运行时捕获
     * ArrayIndexOutOfBoundsException 数组越界异常
     * NullPointerException 空指针异常
     * IllegalArgumentException 非法参数异常
     * NegativeArraySizeException 数组长度为负异常
     * IllegalStateException 非法状态异常
     * ClassCastException 类型转换异常
     *
     * 2. 其余都是 CheckedException
     */

    static void cacheException() throws Exception {
        throw new Exception();
    }
}
