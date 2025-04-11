# 📫 Consulta de Endereços por CEP

Este é um projeto Java simples que consome a API do [ViaCEP](https://viacep.com.br) para buscar informações de endereço a partir de um CEP informado pelo usuário. Os dados são enriquecidos com número e complemento e salvos localmente em um arquivo JSON formatado.

---

## 🧰 Tecnologias utilizadas

- Java 11+
- API HTTP nativa (`java.net.http`)
- Biblioteca [Gson](https://github.com/google/gson) para manipulação de JSON
- API pública ViaCEP
- Escrita de arquivos com `FileWriter`

---

## 📦 Funcionalidades

- Solicita ao usuário:
  - CEP
  - Número
  - Complemento
- Valida o formato do CEP
- Consulta a API ViaCEP
- Constrói um objeto de endereço completo
- Salva os dados em um arquivo `endereco.json`

---

## 🚀 Como executar

### 1. Clone o projeto:

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio
```

### 2. Compile e execute:

Certifique-se de ter o Java instalado e configurado corretamente.

```bash
javac -cp ".;caminho/gson.jar" Main.java
java -cp ".;caminho/gson.jar" Main
```

(Adapte o caminho do `.jar` do Gson conforme seu sistema operacional)

---

## 🗂️ Estrutura de pacotes

- `br.victor.desafio.cep.excecao`: contém a exceção customizada `InvalidCepException`
- `br.victor.desafio.cep.modelos`: contém as classes:
  - `Endereco`
  - `EnderecoViaCep`
  - `ValidadorCep`

---

## 📝 Exemplo de uso

```
Insira o CEP a ser pesquisado: 
01001-000
Insira o número:
123
Insira o complemento: 
Apto 101
```

Arquivo `endereco.json` gerado:

```json
[
  {
    "cep": "01001-000",
    "logradouro": "Praça da Sé",
    "bairro": "Sé",
    "localidade": "São Paulo",
    "uf": "SP",
    "numero": "123",
    "complemento": "Apto 101"
  }
]
```

---

## ❌ Tratamento de erros

- CEP inválido: lança `InvalidCepException` com mensagem apropriada.
- Falha na requisição ou na escrita do arquivo: lança exceções tratadas com mensagens no console.

---

## 📄 Licença

Este projeto é livre para fins de estudo e uso pessoal.

---

Feito com ☕ por Victor.