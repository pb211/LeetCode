#include<stdio.h>
#include<string.h>
#include<stdlib.h>
/*�������鳤��*/
int candidatesLen;
/*������鳤�ȡ�ָ��*/
int resSize;
/*��������г���*/
int* resColumnSize;
/*·�����鳤�ȡ�ָ��*/
int pathSize;
/*�������������*/
int RP40_CombinationSumII_compare(const void *a, const void *b)
{
	return *(int*)a - *(int*)b;
}
void RP40_CombinationSumII_dfs(int* candidates, int** res, int* path, int target, int begin)
{
	if (target < 0)
	{
		return;
	}
	if (target == 0)
	{
		//����������ڴ�ռ䣬������һ��ָ������ָ��
		int* temp = malloc(sizeof(int)*pathSize);
		for (int i = 0; i < pathSize; i++)
		{
			temp[i] = path[i];
		}
		res[resSize] = temp;
		resColumnSize[resSize++] = pathSize;
		return;
	}
	for (int i = begin; i < candidatesLen; i++)
	{
		if (target - candidates[i] < 0)
		{
			continue;
		}
		if (i > begin && candidates[i] == candidates[i - 1])
		{
			continue;
		}
		/*����ǰ�����ӵ�·����*/
		path[pathSize++] = candidates[i];
		RP40_CombinationSumII_dfs(candidates, res, path, target - candidates[i], i + 1);
		/*ÿ�ҵ�һ��·��������״̬*/
		pathSize--;
	}
}
int** combinationSum2(int* candidates, int candidatesSize, int target, int* returnSize, int** returnColumnSizes)
{
	/*��ȡ�������鳤��*/
	candidatesLen = candidatesSize;
	/*������鳤�ȡ�ָ�룬·�����鳤�ȡ�ָ��*/
	resSize = pathSize = 0;
	/*�������*/
	int** res = malloc(sizeof(int*) * 1001);
	/*������*/
	resColumnSize = malloc(sizeof(int) * 1001);
	/*·������*/
	int path[2001];
	/*������������*/
	qsort(candidates, candidatesSize, sizeof(int), RP40_CombinationSumII_compare);
	RP40_CombinationSumII_dfs(candidates, res, path, target, 0);
	*returnSize = resSize;
	/*���������г���*/
	*returnColumnSizes = resColumnSize;
	return res;
}
