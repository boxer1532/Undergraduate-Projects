
/* ----------------------------------------------------------------------------------------------------
*  ����: assignment_2_1.c
*  ���	: 10~100���̿� ���ڷ� ���ڸ��߱� ������ ���� ����� 2��, Ʋ���ÿ� -1�� ȹ��.(�ʱ����� 10��)
          point�� 20�� �̻��� �� ���ӿ��� �¸��ߴٴ� ���� ��� or 0���� �� ���ӿ��� ���ٴ� ������� �Ŀ� ���α׷� ����
*  ������: 201420907 �ȿ���
*  ��¥	: 1�� ���� : 2016�� 10�� 9��
          2�� ���� : 2016�� 10�� 12��
*----------------------------------------------------------------------------------------------------*/
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(void)
{
	int target = 0, guess = 0; //������ target, �Է¹޴� ���� guess
	int point = 10; //�ʱ����� 10��
	int trial;

	while (1)
	{

		srand((unsigned int)time(NULL));
		target = rand() % 89 + 11; //10�� 100����(11~99)�� ���� ����
		trial = 0; //�õ�Ƚ�� 0ȸ�� �ʱ�ȭ

		printf("10~100������ ���� ���߱� ����(20���̻� �¸� / 0���� �й�)\n");
		printf("���������� %d���̰�, �õ�Ƚ���� 6ȸ�� �Ѿ�� �� ������ ���۵˴ϴ�.\n\n",point);

		while (trial != 6 && point > 0 && point < 20) 
		{
			while (1)
			{
				printf("10~100������ ������ �Է��ϼ��� : "); 
				scanf_s("%d", &guess);  //guess���� �Է¹��� 
				getchar();

				if (guess >= 100 || guess <= 10) //0<guess<100 ���� �Ǻ�
					printf("10-100���� ������ �ƴմϴ�. �ٽ� �Է����ּ���.\n");
				else
					break;
			}
			trial++; //�õ�Ƚ�� 1����

			if (guess > target)
			{
				point--; //point -1 
				printf("target�� �Է��� ���ں��� �۽��ϴ�(%d��° �õ�, point:%d)\n", trial, point);
			}
			else if (guess < target)
			{
				point--; //point -1 
				printf("target�� �Է��� ���ں��� Ů�ϴ�(%d��° �õ�, point:%d)\n", trial, point);
			}
			else if (guess == target)
			{
				point += 2; //point +2
				printf("target�� ���߼̽��ϴ�!(%d��° �õ�, point:%d)\n\n", trial, point);
				break; //���� Ż��
			}
		}

		if (point == 0)
		{
			printf("\npoint�� 0���� �Ǿ� ���ӿ��� ���̽��ϴ�.\n");
			break; 
		}
		else if (point >= 20)
		{
			printf("\npoint�� 20���̻��� �Ǿ� ���ӿ��� �̱�̽��ϴ�.\n");
			break; 
		}
		else if (trial == 6)
		{
			printf("���ѽõ�Ƚ�� %dȸ�� �ʰ��Ͽ����ϴ�.\n\n������ �ٽ� �����մϴ�.\n", trial);
			continue; //�� ���� ����
		}
		
	}
	return 0;
}