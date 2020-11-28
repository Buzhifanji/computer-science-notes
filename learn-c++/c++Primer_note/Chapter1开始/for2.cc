#include <iostream>

int main()
{
    int sum = 0, value = 0;
    // 读取数据之道遇到文件尾， 计算所有读入值的和
    while(std::cin >> value) {
        sum += value;
    }
    std::cout << "Sum is: " << sum << std::endl;
    return 0;
}