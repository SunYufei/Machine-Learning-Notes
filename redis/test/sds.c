#include "../sds.h"
#include <stdio.h>

int main(int argc, char const *argv[]) {
    struct sdshdr16 sds16;
    struct sdshdr32 sds32;
    printf("%ld\n", sizeof sds16);
    printf("%ld\n", sizeof sds32);
    return 0;
}