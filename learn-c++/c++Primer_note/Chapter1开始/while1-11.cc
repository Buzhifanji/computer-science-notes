#include <iostream>

int main()
{
    std::cout << "Enter two number";
    int v1 = 0, v2 = 0;
    std::cin >> v1 >> v2;
    while (v1 != v2) {
        if (v1 > v2) {
            std::cout << v2 << std::endl;
            ++v2;
        } else {
            std::cout << v1 << std::endl;
            ++v1;
        }
    }
    std::cout << v1 << std::endl;
}