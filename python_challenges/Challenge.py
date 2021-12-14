def sort_list(list1, order):
	if order == 'asc':
		return sorted(list1)
	elif order == 'desc':
		return sorted(list1, reverse = True)
	elif order == 'none':
		return list1
