fun main() {
    print("Số lượng phân số: ")
    val n = readln().toInt()
    val arr = mutableListOf<fraction>()

    // Nhập mảng
    repeat(n) { i ->
        println("Phân số thứ ${i + 1}:")
        val ps = fraction()
        ps.Input()
        arr.add(ps)
    }

    // In mảng phân số
    println("\nDãy phân số vừa nhập:")
    arr.forEach { it.Print() }

    // Tối giản mảng
    println("\nMảng sau khi tối giản:")
    arr.forEach { it.toiGian(); it.Print() }

    // Tổng
    var tong = fraction(0, 1)
    arr.forEach { tong = tong.Sum(it) }
    println("\nTổng:")
    tong.Print()

    // Phân số lớn nhất
    val max = arr.maxByOrNull { it.numerator.toDouble() / it.denominator }!!
    println("\nPhân số lớn nhất:")
    max.Print()

    // Xếp mảng giảm dần
    val sortedArr = arr.sortedByDescending { it.numerator.toDouble() / it.denominator }
    println("\nMảng giảm dần:")
    sortedArr.forEach { it.Print() }
}

