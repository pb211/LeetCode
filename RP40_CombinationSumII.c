#include<stdio.h>
#include<string.h>
#include<stdlib.h>
/*待查数组长度*/
int candidatesLen;
/*结果数组长度、指针*/
int resSize;
/*结果数组列长度*/
int* resColumnSize;
/*路经数组长度、指针*/
int pathSize;
/*对数组进行排序*/
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
		//分配所需的内存空间，并返回一个指向它的指针
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
		/*将当前结点添加到路径中*/
		path[pathSize++] = candidates[i];
		RP40_CombinationSumII_dfs(candidates, res, path, target - candidates[i], i + 1);
		/*每找到一个路经，重置状态*/
		pathSize--;
	}
}
int** combinationSum2(int* candidates, int candidatesSize, int target, int* returnSize, int** returnColumnSizes)
{
	/*获取待查数组长度*/
	candidatesLen = candidatesSize;
	/*结果数组长度、指针，路经数组长度、指针*/
	resSize = pathSize = 0;
	/*结果数组*/
	int** res = malloc(sizeof(int*) * 1001);
	/*列数组*/
	resColumnSize = malloc(sizeof(int) * 1001);
	/*路经数组*/
	int path[2001];
	/*进行升序排序*/
	qsort(candidates, candidatesSize, sizeof(int), RP40_CombinationSumII_compare);
	RP40_CombinationSumII_dfs(candidates, res, path, target, 0);
	*returnSize = resSize;
	/*返回数组列长度*/
	*returnColumnSizes = resColumnSize;
	return res;
}
