# 🐖 SGGS Pro API (Sistema de Gerenciamento de Granja Suína)

Uma API RESTful robusta desenvolvida para a digitalização e gestão eficiente de operações suinícolas. Este projeto foi concebido para atender às demandas de controle zootécnico e sanitário em granjas, oferecendo um back-end seguro e escalável para rastreamento de animais, nutrição e vacinação.

Projeto desenvolvido como entrega final para o programa de capacitação profissional **Capacita**.

---

## 🎯 Visão Geral do Projeto

O SGGS Pro automatiza o fluxo de informações no agronegócio, permitindo que produtores rurais substituam planilhas manuais por um sistema centralizado. A arquitetura garante que dados sensíveis da granja (como protocolos de vacinação e custos implícitos em ração) estejam protegidos por autenticação de nível industrial, ao mesmo tempo em que fornece relatórios instantâneos para tomada de decisão.

## 🚀 Funcionalidades (Módulos)

*   **🔐 Autenticação e Segurança (Auth):**
    *   Criação de usuários gerenciais.
    *   Login seguro com geração de Token JWT (JSON Web Token).
    *   Bloqueio de rotas não autorizadas.
*   **🐷 Gestão de Plantel (Suínos):**
    *   Cadastro detalhado de animais (número, peso, idade, raça e finalidade).
    *   Consultas e atualizações de registros.
*   **💉 Controle Sanitário (Vacinação):**
    *   Registro de vacinas aplicadas por animal.
    *   Controle de datas e doses (rastreabilidade sanitária).
*   **🌽 Manejo Nutricional (Alimentação):**
    *   Registro de fornecimento de ração.
    *   Controle de tipo de dieta e volume em Kg.
*   **📊 Dashboard Gerencial (Relatórios):**
    *   Geração de métricas consolidadas em tempo real.
    *   Cálculo de total de animais ativos, histórico de vacinas e volume total de ração consumida.

---

## 🛠️ Tecnologias e Arquitetura

Este projeto foi construído utilizando os padrões mais modernos do ecossistema Java:

*   **Linguagem:** Java 21
*   **Framework Principal:** Spring Boot 3
*   **Persistência de Dados:** Spring Data JPA / Hibernate
*   **Banco de Dados:** H2 Database (In-Memory, ideal para testes e validações rápidas)
*   **Segurança:** Spring Security + JWT
*   **Produtividade:** Lombok (Redução de boilerplate)
*   **Documentação:** Swagger / OpenAPI 3
*   **Validação:** Hibernate Validator (Bean Validation)

### Padrões de Projeto Aplicados
*   **Arquitetura em Camadas (Layered Architecture):** Separação clara entre `Controller`, `Service`, `Repository`, `Entity` e `Security`.
*   **DTO (Data Transfer Object):** Isolamento das entidades de banco de dados do tráfego da rede, garantindo segurança e formatação customizada de respostas.
*   **Global Exception Handling:** Captura centralizada de erros para retorno de mensagens HTTP claras (400 Bad Request, 404 Not Found, 403 Forbidden).

---

## ⚙️ Como Executar o Projeto Localmente

**Pré-requisitos:**
*   Java 21 instalado (JDK 21)
*   Maven
*   Git

**Passo a passo:**

1. **Clone o repositório:**
   ```bash
   git clone [https://github.com/SEU_USUARIO/sggs-pro-api.git](https://github.com/SEU_USUARIO/sggs-pro-api.git)
