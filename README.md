# STOOM-Teste de Qualificação Backend

O teste consiste em criar no padrão REST, um CRUD (Create, Read, Update, Delete) de uma entidade endereço com os seguintes atributos:

- id*
- streetName*
- number*
- complement
- neighbourhood*
- city*
- state*
- country*
- zipcode*
- latitude
- longitude

**Obs.:** Os atributos marcados com * devem ser obrigatórios



## Obrigatório

1- Deve-se utilizar Java para criação desse CRUD. O framework pode ser o que se sentir mais à vontade.

**->concluido**


2- Deve-se criar um repositório público no github para compartilhar o teste e este ser enviado ao examinador na conclusão

**->concluido**



## Diferenciais

1- Quando latitude e longitude não forem informados, o sistema precisa buscar essa informação utilizando a Geocoding API do Google (https://developers.google.com/maps/documentation/geocoding/start)

- Use a chave temporária enviada por e-mail

**->inacabado, branch feature/geocoding-api**


2- Criar um Dockerfile funcional com o projeto

- Obs.: Não precisa se preocupar com banco de dados no Dockerfile, ele será executado usando em nosso ambiente que já irá considerar isso

**->Não feito**


3- Criar ao menos um teste unitário básico para cada ação (Create, Read, Update, Delete)

**->concluido**

## Postman Collection

A seguir tem o link para importar uma collection básica com os endpoints:

https://www.getpostman.com/collections/abf54f52a58e90b29594
