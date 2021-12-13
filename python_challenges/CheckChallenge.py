import sys

the_challenge = sys.argv[1]


def run(challenge):
    if challenge == "dec_to_bin":
        from Challenge import dec_to_bin
        print(dec_to_bin(0), dec_to_bin(4), dec_to_bin(10), dec_to_bin(31))

    elif challenge == "remove_nums":
        from Challenge import remove_nums
        print(remove_nums("H3e55llo099 3W345orl324d"))

    elif challenge == "X_is_O":
        from Challenge import X_is_O
        print(X_is_O("XXXOOOXOXO"), X_is_O("XOX"))

    elif challenge == "is_palindrome":
        from Challenge import is_palindrome
        print(is_palindrome("123456789987654321"), is_palindrome("123412341234431"))

    elif challenge == "calculator":
        from Challenge import calculator
        print(calculator(4, 8, "+"), calculator(8, 16, "-"), calculator(8, 8, "*"), calculator(18, 18, "/"))

    elif challenge == "sort_list":
        from Challenge import sort_list
        print(sort_list([2, 1, 4, 3], "asc"), sort_list([4, 2, 6, 8], "desc"), sort_list([5, 5, 3, 7], "none"))


run(the_challenge)
