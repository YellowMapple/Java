# Java
Arrays.stream(vat).max().getAsInt() 是使用 Java 8 的流式操作对数组 vat 进行处理，找到其中的最大值。

Arrays.stream(vat) 将数组 vat 转换为一个流，然后使用 max() 方法找到流中的最大值。由于 max() 方法返回的是一个 Optional 对象，因此使用 getAsInt() 方法将最大值提取为一个整数类型。

这行代码的作用是找到数组 vat 中的最大值，并将其作为结果返回。
