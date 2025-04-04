fun main() {
    testIP(
        testCase = "Giving a ip Out of range number (256), should return false",
        ip = "192.168.40.256",
        expected = false
    )
    testIP(
        testCase = "Giving a ip a negative number, should return false",
        ip = "192.168.40.-1",
        expected = false
    )
    testIP(
        testCase = "Giving a ip with a segment that starts with the leading zero, should return false",
        ip = "192.168.40.056",
        expected = false
    )
    testIP(
        testCase = "Giving a ip with an additional segment has been added, should return false",
        ip = "192.168.40.256.54",
        expected = false
    )
    testIP(
        testCase = "Giving a ip with an extra point was added, should return false",
        ip = "192.168.40.256.",
        expected = false
    )
    testIP(
        testCase = "Giving a ip with a letter has been added to the segment, should return false",
        ip = "192.16A.40.256",
        expected = false
    )
    testIP(
        testCase = "Giving a ip with Only one segment added, should return false",
        ip = "192",
        expected = false
    )
    testIP(
        testCase = "Giving a empty ip, should return false",
        ip = "",
        expected = false
    )
    testIP(
        testCase = "Giving a Valid IP, should return true",
        ip = "192.168.0.1",
        expected = true
    )

}

fun ipAddressValidator(ip: String): Boolean {
    val segments = ip.split(".")
    if (segments.size != 4) return false

    for (segment in segments) {
        if (segment.isEmpty() || !segment.all { it.isDigit() }) return false
        if (segment.length > 1 && segment.startsWith("0")) return false
        val number = segment.toIntOrNull() ?: return false
        if (number !in 0..255) return false
    }
    return true
}

fun testIP(testCase: String, ip: String, expected: Boolean) {
    val actual = ipAddressValidator(ip)
    println("Test case: $testCase IP: $ip Expected: $expected, Got: $actual Test ${if (actual == expected) "PASSED" else "FAILED"}")
}
