#include <linux/init.h>
#include <linux/module.h>
#include <linux/kernel.h>

static int hello_init(void) {
    printk(KERN_ALERT "Hello init method is called");
    return 0;
}

static void hello_exit(void) {
    printk(KERN_ALERT "Exit function is called");
}

module_init(hello_init);
module_exit(hello_exit);

MODULE_LICENSE("GPL");
MODULE_AUTHOR("A server");
MODULE_DESCRIPTION("A hello world module ;P");
