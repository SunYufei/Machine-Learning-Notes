#ifndef __ZMALLOC_H_
#define __ZMALLOC_H_

#include <stddef.h>

void *zmalloc(size_t size);
void zfree(void *ptr);

#endif