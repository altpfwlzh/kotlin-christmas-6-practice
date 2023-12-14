package christmas.util

import camp.nextstep.edu.missionutils.Randoms

class RandNumGenerator {
    fun generateRandNum(startNum: Int, endNum: Int): Int = Randoms.pickNumberInRange(startNum, endNum)

    fun generateRandNums(startNum: Int, endNum: Int, count: Int = 1): List<Int> = Randoms.pickUniqueNumbersInRange(startNum, endNum, count)
}