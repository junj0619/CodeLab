## Fibonacci

<pre>
<strong>f(n) = f(n - 1) + f(n - 2) </strong>
ex: f(7) = 13
    1, 1, 2, 3, 5, 8, 13
</pre>


### Top-Down 

```java
public int fib(n) {
    int[] fb = new int[n + 1];
    fb[1] = 1, fb[2] = 1;
    return fib(n, fb);
}

private int fib(int n, int[] fb) {
    if (n <= 2) return 1;
    if (fb[n] > 0) return fb[n];

    fb[n] = fib(n - 1) + fib(n - 2);
    return fb[n];
}

```


### Bottom-up

```java
public int fib(n) {
    int[] fb = new int[n + 1];
    fb[1] = 1, fb[2] = 1;

    for (int i = 3; i <= n; i++) {
        fb[i] = fb[i - 1] + fb[i - 2];
    }
    return fb[n];
}
```
