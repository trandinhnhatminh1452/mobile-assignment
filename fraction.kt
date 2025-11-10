class fraction(var numerator: Int = 0, var denominator: Int = 1) {

    // Input
    fun Input() {
        do {
            print("Nhập tử số: ")
            numerator = readln().toInt()
            print("Nhập mẫu số: ")
            denominator = readln().toInt()
            if (denominator == 0) println("Mẫu số phải khác 0!")
        } while (denominator == 0)
    }

    // Print
    fun Print() {
        println("$numerator/$denominator")
    }

    // UCLN
    private fun ucln(a: Int, b: Int): Int {
        var x = kotlin.math.abs(a)
        var y = kotlin.math.abs(b)
        while (y != 0) {
            val t = y
            y = x % y
            x = t
        }
        return x
    }

    // Tối giản 
    fun toiGian() {
        val u = ucln(numerator, denominator)
        numerator /= u
        denominator /= u
        if (denominator < 0) { // luôn để mẫu số > 0
            numerator = -numerator
            denominator = -denominator
        }
    }

    // So sánh 
    fun compare(other: fraction): Int {
        val a = this.numerator * other.denominator
        val b = this.denominator * other.numerator
        return when {
            a < b -> -1
            a == b -> 0
            else -> 1
        }
    }

    // Sum
    fun Sum(other: fraction): fraction {
        val ts = this.numerator * other.denominator + other.numerator * this.denominator
        val ms = this.denominator * other.denominator
        val res = fraction(ts, ms)
        res.toiGian()
        return res
    }
}
