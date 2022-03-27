#include <stdint.h>

// __attribute__ ((__packed__))
// 告诉编译器取消结构体在编译过程中的优化对齐
// 按照实际占用字节数进行对齐
struct __attribute__ ((__packed__)) sdshdr16 {
   uint16_t len;
   uint16_t alloc;
   unsigned char flags;
   char buf[];
};

struct __attribute__ ((__packed__)) sdshdr32 {
   uint32_t len;
   uint32_t alloc;
   unsigned char flags;
   char buf[];
};

