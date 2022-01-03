def arithmetic_arranger(problems, condition=False):
  # check for errors
  if len(problems) > 5:
    return 'Error: Too many problems.'
  for problem in problems:
    if not (problem.split()[1]=='+' or problem.split()[1]=='-'):
      return 'Error: Operator must be \'+\' or \'-\'.'
    elif not (problem.split()[0].isdigit() and problem.split()[2].isdigit()):
      return 'Error: Numbers must only contain digits.'
    elif (len(problem.split()[0]) > 4 or len(problem.split()[2]) > 4):
      return 'Error: Numbers cannot be more than four digits.'
    else:
      pass
  
  num1 = list()
  num2 = list()
  num1int = list()
  num2int = list()
  operator = list()
  answer = list()
  dash = '-'
  tspace = '      '
  bspace = '    '

  for item in problems:
    num1.append(item.split()[0])
    num2.append(item.split()[2])
    operator.append(item.split()[1]+' ')
    num1int.append(int(item.split()[0]))
    num2int.append(int(item.split()[1]+item.split()[2]))

  i = 0

  for i in range(len(problems)):
    num1[i] = num1[i].rjust(max(len(num1[i]),len(num2[i])))
    num2[i] = num2[i].rjust(max(len(num1[i]),len(num2[i])))
    answer.append(num1int[i]+num2int[i])
    answer[i] = str(answer[i]).rjust(len(dash*(max(len(num1[i]),len(num2[i]))+2)))

  if condition is True:
    if len(problems)==1:
      output12 = f'''  {num1[0]}
{operator[0]}{num2[0]}
{dash*(max(len(num1[0]),len(num2[0]))+2)}
{answer[0]}'''
      return output12
    elif len(problems)==2:
      output22 = f'''  {num1[0]}{tspace}{num1[1]}
{operator[0]}{num2[0]}{bspace}{operator[1]}{num2[1]}
{dash*(max(len(num1[0]),len(num2[0]))+2)}{bspace}{dash*(max(len(num1[1]),len(num2[1]))+2)}
{answer[0]}{bspace}{answer[1]}'''
      return output22
    elif len(problems)==3:
      output32 = f'''  {num1[0]}{tspace}{num1[1]}{tspace}{num1[2]}
{operator[0]}{num2[0]}{bspace}{operator[1]}{num2[1]}{bspace}{operator[2]}{num2[2]}
{dash*(max(len(num1[0]),len(num2[0]))+2)}{bspace}{dash*(max(len(num1[1]),len(num2[1]))+2)}{bspace}{dash*(max(len(num1[2]),len(num2[2]))+2)}
{answer[0]}{bspace}{answer[1]}{bspace}{answer[2]}'''
      return output32
    elif len(problems)==4:
      output42 = f'''  {num1[0]}{tspace}{num1[1]}{tspace}{num1[2]}{tspace}{num1[3]}
{operator[0]}{num2[0]}{bspace}{operator[1]}{num2[1]}{bspace}{operator[2]}{num2[2]}{bspace}{operator[3]}{num2[3]}
{dash*(max(len(num1[0]),len(num2[0]))+2)}{bspace}{dash*(max(len(num1[1]),len(num2[1]))+2)}{bspace}{dash*(max(len(num1[2]),len(num2[2]))+2)}{bspace}{dash*(max(len(num1[3]),len(num2[3]))+2)}
{answer[0]}{bspace}{answer[1]}{bspace}{answer[2]}{bspace}{answer[3]}'''
      return output42
    else:
      output52 = f'''  {num1[0]}{tspace}{num1[1]}{tspace}{num1[2]}{tspace}{num1[3]}{tspace}{num1[4]}
{operator[0]}{num2[0]}{bspace}{operator[1]}{num2[1]}{bspace}{operator[2]}{num2[2]}{bspace}{operator[3]}{num2[3]}{bspace}{operator[4]}{num2[4]}
{dash*(max(len(num1[0]),len(num2[0]))+2)}{bspace}{dash*(max(len(num1[1]),len(num2[1]))+2)}{bspace}{dash*(max(len(num1[2]),len(num2[2]))+2)}{bspace}{dash*(max(len(num1[3]),len(num2[3]))+2)}{bspace}{dash*(max(len(num1[4]),len(num2[4]))+2)}
{answer[0]}{bspace}{answer[1]}{bspace}{answer[2]}{bspace}{answer[3]}{bspace}{answer[4]}'''
      return output52
  elif len(problems)==1:
    output11 = f'''  {num1[0]}
{operator[0]}{num2[0]}
{dash*(max(len(num1[0]),len(num2[0]))+2)}'''
    return output11
  elif len(problems)==2:
    output21 = f'''  {num1[0]}{tspace}{num1[1]}
{operator[0]}{num2[0]}{bspace}{operator[1]}{num2[1]}
{dash*(max(len(num1[0]),len(num2[0]))+2)}{bspace}{dash*(max(len(num1[1]),len(num2[1]))+2)}'''
    return output21
  elif len(problems)==3:
    output31 = f'''  {num1[0]}{tspace}{num1[1]}{tspace}{num1[2]}
{operator[0]}{num2[0]}{bspace}{operator[1]}{num2[1]}{bspace}{operator[2]}{num2[2]}
{dash*(max(len(num1[0]),len(num2[0]))+2)}{bspace}{dash*(max(len(num1[1]),len(num2[1]))+2)}{bspace}{dash*(max(len(num1[2]),len(num2[2]))+2)}'''
    return output31
  elif len(problems)==4:
    output41 = f'''  {num1[0]}{tspace}{num1[1]}{tspace}{num1[2]}{tspace}{num1[3]}
{operator[0]}{num2[0]}{bspace}{operator[1]}{num2[1]}{bspace}{operator[2]}{num2[2]}{bspace}{operator[3]}{num2[3]}
{dash*(max(len(num1[0]),len(num2[0]))+2)}{bspace}{dash*(max(len(num1[1]),len(num2[1]))+2)}{bspace}{dash*(max(len(num1[2]),len(num2[2]))+2)}{bspace}{dash*(max(len(num1[3]),len(num2[3]))+2)}'''
    return output41
  else:
    output51 = f'''  {num1[0]}{tspace}{num1[1]}{tspace}{num1[2]}{tspace}{num1[3]}{tspace}{num1[4]}
{operator[0]}{num2[0]}{bspace}{operator[1]}{num2[1]}{bspace}{operator[2]}{num2[2]}{bspace}{operator[3]}{num2[3]}{bspace}{operator[4]}{num2[4]}
{dash*(max(len(num1[0]),len(num2[0]))+2)}{bspace}{dash*(max(len(num1[1]),len(num2[1]))+2)}{bspace}{dash*(max(len(num1[2]),len(num2[2]))+2)}{bspace}{dash*(max(len(num1[3]),len(num2[3]))+2)}{bspace}{dash*(max(len(num1[4]),len(num2[4]))+2)}'''
    return output51
