#ifndef __ADLIST_H__
#define __ADLIST_H__

typedef struct listNode {
    // 前置结点
    struct listNode *prev;
    // 后置结点
    struct listNode *next;
    // 结点值
    void *value;
} listNode;

typedef struct list {
    listNode *head;
    listNode *tail;
    // 结点值复制函数
    void *(*dup)(void *ptr);
    // 结点值释放函数
    void *(*free)(void *ptr);
    // 结点值比较函数
    int (*match)(void *ptr, void *key);
    // 链表结点数量
    unsigned long len;
};

#endif