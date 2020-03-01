#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <algorithm>

using namespace std;

int checkPalindrome(char* buff)
{
	int ret = 0;
	// write code here
	char twice_buff[511] = { 0 }; // ���̰� (2n+1)�� �迭 
	int rad[510] = { 0 }; // �������� ���̸� ������ �迭
	int maxR = 0, p = 0;
	int n = strlen(buff); // ���ڿ��� ����

	// ¦���� ȸ���� ���ϱ� ���� ���̻��̿� '#' �߰���
	for (int i = 0; i <= strlen(buff); i++)
	{
		twice_buff[2 * i] = '#';
		twice_buff[2 * i + 1] = buff[i];
	}

	// '#'�� �߰��� ���ڿ��� ����
	int N = strlen(twice_buff);

	// rad[i] �迭�� ���� ���� ���ϴ� �ݺ���
	for (int i = 1; i <= N; i++)
	{
		if (i <= maxR)
			rad[i] = min(rad[2 * p - i], maxR - i);
		else
			rad[i] = 0;

		while (i - rad[i] - 1 >= 0 && i + rad[i] + 1 <= N && twice_buff[i - rad[i] - 1] == twice_buff[i + rad[i] + 1])
			rad[i]++;

		if (maxR < i + rad[i])
			maxR = i + rad[i], p = i;
	}

	// ���� ���ڿ��� rad���� �����ֱ� ���� 2�� ������
	for (int i = 0; i <= N; i++)
	{
		rad[i] /= 2;
	}

	// 0~(N-1)�� rad[i]���� ��� ������
	for (int k = 0; k < N; k++)
		ret += rad[k];

	printf("\n%d\n", ret);
	return ret;
}

int main(void)
{
	char buff[255];
	int nTest;

	FILE *fp = freopen("input.txt", "rt", stdin);
	if (fp == NULL) {
		fprintf(stderr, "File not found\n");
		return 0;
	}

	scanf("%d", &nTest);

	for (int i = 0; i < nTest; i++) {
		scanf("%s", buff);
		checkPalindrome(buff);
	}
	printf("\n");
	fclose(fp);
	return 1;
}