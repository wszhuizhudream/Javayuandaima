package com.wschase.jdbc.complete1;

/**表的数据成员：表的列
 * Author:WSChase
 * Created:2019/3/25
 */
public class TableMember<T> {
    //先假设我们的表格只有3列
    private T column1;
    private T column2;
    private T column3;

    public T getColumn1() {
        return column1;
    }

    public void setColumn1(T column1) {
        this.column1 = column1;
    }

    public T getColumn2() {
        return column2;
    }

    public void setColumn2(T column2) {
        this.column2 = column2;
    }

    public T getColumn3() {
        return column3;
    }

    public void setColumn3(T column3) {
        this.column3 = column3;
    }

    @Override
    public String toString() {
        return "TableMember{" +
                "column1=" + column1 +
                ", column2=" + column2 +
                ", column3=" + column3 +
                '}';
    }
}
