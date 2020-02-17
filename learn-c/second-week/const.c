#include <stdio.h>

int main()
{
	const int AMOUT = 100;
	int price = 0;
	
	printf("请输入金额（元）：");
	scanf("%d", &price);
	
	int change = AMOUT - price;
	
	printf("找您%d元。\n",change);
	
	return 0;
}
