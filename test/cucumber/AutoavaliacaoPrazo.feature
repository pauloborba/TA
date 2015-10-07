#Requerimento: Autoavaliação (divulgação com prazo)
#
#Feature A: Requisição de autoavaliação.
#	Como um professor da disciplina.
#	Eu quero definir o prazo em que será possível divulgar autoavaliações e notificar os alunos.
#	De modo que eles estejam avisados e divulguem-nas dentro do período de tempo programado.
#
## (Eduardo Ximenes - diest)
## Você poderia ter dividido o passo "Em seguida" em dois com um passo 'And' (ou 'E') para facilitar a visão.
## Priorizar passos curtos é uma boa prática da escrita de cenários.
#
#Cenário 1: Criação do prazo.
#	Dado que estou logado no sistema na minha página de perfil.
#	Quando eu solicitar a criação de um prazo de autoavaliação.
#	Em seguida o sistema registrará o período de tempo pedido e enviará um e-mail de notificação desse prazo para os alunos da disciplina.
#
## (Eduardo Ximenes - diest)
## Igual ao cenário 1, o passo "Em seguida" está demasiadamente longo.
#
#Cenário 2: Edição de prazo.
#	Dado que preciso modificar a data do prazo.
#	Quando eu solicitar a edição do prazo de autoavaliação.
#	Em seguida, o sistema registrará o novo período de tempo pedido e enviará um e-mail avisando sobre a alteração aos alunos da disciplina.
#
## (Eduardo Ximenes - diest)
## Você está colocando duas situações diferentes de erro. Segundo Paulo, dever-se-ia fazer um cenário para cada uma.
## O "Em seguida" não está longo, mas poderia estar dividido para separar bem cada ação.
#
#Cenário 3: Data inexistente ou anterior ao período da disciplina.
#	Dado que tento criar um prazo de autoavaliação.
#	Quando registro uma data inexistente ou que existe anteriormente à data de início da disciplina.
#	Em seguida, o sistema me avisa do erro e solicita uma nova data.
#
#Cenário 4: Data posterior ao período da disciplina.
#	Dado que tento criar um prazo de autoavaliação.
#	Quando registro uma data que existe posteriormente à data de início da disciplina.
#	Em seguida, o sistema me pergunta se desejo mesmo registrar a nova data solicitada.
#
## (Eduardo Ximenes - diest)
## Faltaram cenários de interface gráfica.
