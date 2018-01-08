1:对于webservice的理解。

wsdl:definitions:根节点，首先根节点是wsdl:definitions表示这是一个
wsdl文件。

wsdl:service提供了一个地址，如果你想访问这个服务调用这个地址就行。

wsdl:binding:服务的协议，列如使用了soap协议。

wsdl:portType:具体服务集合，有哪些方法可以操作，方法的入参是什么，出参是什么。

wsdl:message。消息的详细信息，详细描述了出参是什么，入参是什么。

2：对于maven的理解。

groupId :是公司名或者组织名，一般groupId是有3个部分组成，

每个部分之间以.分割，第一部分是项目用途，如果是商业就com用于非营利性组织就

org.。第二部分是公司名，比如，tengxun,baidu,albaba.。第三部分就是项目名。

artifactId.可以认为是maven构建的项目名，比如你的项目有子项目就可以用项目名-子项目名的
命名方式。

version版本号。SHAPSHOT意为快照，

build 表示与项目构建有关的，build下有fileName表示最终构建之后的项目名。

WM_CONCAT,该函数可以把列的值以“,”号分割起来，并显示成一行。oracle中的应用。

GROUP_CONCAT函数返回一个字符串结果，改结果是有分组中的值连接组合而成并显示成一行，和oracle中的WM_CONCAT用法相同。