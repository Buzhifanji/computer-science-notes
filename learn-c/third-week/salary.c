#include <stdio.h>

int main()
{
	const double RATE = 8.25;
	const int STARTARD = 40;
	double pay = 0.0;
	int hours;
	
	printf("请输入工作的小时数: ");
	scanf("%d", &hours);
	printf("\n");
	if (hours > STARTARD) {
		pay = STARTARD * RATE + (hours - STARTARD) * (RATE * 1.5);
	} else {
		pay = hours * RATE;
	}
	
	printf("应付工资：%f\n", pay);
	
	return 0;
}
