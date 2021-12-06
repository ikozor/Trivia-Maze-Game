import sys

challenge = sys.argv[1]
if challenge == "dec_to_bin":
    from Challenge import dec_to_bin
    print(dec_to_bin)
elif challenge == "remove_nums":
    from Challenge import remove_nums
    print(remove_nums)
elif challenge == "X_is_O":
    from Challenge import X_is_O
    print(X_is_O)
elif challenge == "is_palindrome":
    from Challenge import is_palindrome
    print(is_palindrome)
elif challenge == "calculator":
    from Challenge import calculator
    print(calculator)
else:
    from Challenge import sort_list
    print(sort_list)
