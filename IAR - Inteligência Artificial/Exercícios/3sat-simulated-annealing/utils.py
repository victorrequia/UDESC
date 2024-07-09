def read_file(filaname: str):
    clauses = []
    variables = set()
    with open(filaname, 'r', encoding='utf-8') as f:
        for line in f:
            if line.startswith('%'):
                break
            if line.startswith('c'):
                continue
            if line.startswith('p'):
                continue
            clause = [int(x) for x in line.split()]
            clause.pop() # remove the last 0, 0 = AND operator
            
            clauses.append(clause)
            for x in clause:
                variables.add(abs(x))
    return clauses, variables