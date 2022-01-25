#include <linux/init.h>
#include <linux/module.h>
#include <linux/kernel.h>

//Input variables
static int input_1 = 1;
static char *input_string = "Default string value";
static int myIntArray[3] = {-2, -2, -2};
static int arr_arg_size = 0;

module_param(input_1, int, 0644);
module_param(input_string, charp, 0000); //Is a pointer
module_param_array(myIntArray, int, &arr_arg_size, 0000);

static int __init hello_init(void) {
    int i = 0;
    printk(KERN_INFO "Hello init method is called\n");
    printk(KERN_INFO "My parameter (int) value is: %d\n", input_1);
    printk(KERN_INFO "My parameter (String) value is: %s\n", input_string);
   
    for(i = 0; i < (sizeof myIntArray / sizeof (int)); i ++) {
    	printk(KERN_INFO "Array element: %d value:%d\n", i, myIntArray[i]);
    }

    printk(KERN_INFO "Got %d elements for the input array", arr_arg_size);
    return 0;
}

static void __exit hello_exit(void) {
    printk(KERN_INFO "Exit function is called\n");
}

module_init(hello_init);
module_exit(hello_exit);

MODULE_LICENSE("GPL");
MODULE_AUTHOR("A server");
MODULE_DESCRIPTION("A hello world module ;P");
