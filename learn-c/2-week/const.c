#include <stdio.h>

int main()
{
	const int AMOUT = 100;
	int price = 0;
	
	printf("�������Ԫ����");
	scanf("%d", &price);
	
	int change = AMOUT - price;
	
	printf("����%dԪ��\n",change);
	
	return 0;
}
