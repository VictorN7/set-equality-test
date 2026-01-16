# 🧩 Coleções em Java — Set, HashSet e TreeSet


## ❓ O que são

**As implementações de Set representam uma coleção que:**

- ❌ Não permite elementos duplicados
- ❌ Não possui acesso por índice
- ✔️ Armazena elementos únicos com base em regras de comparação


## ✨ Principais implementações:

- HashSet
- TreeSet

## 💭 Para que servem

**São utilizadas quando é necessário:**

- Garantir unicidade dos elementos
- Realizar buscas rápidas
- Trabalhar com ou sem ordenação automática

**Cada implementação possui uma estratégia diferente para:**

- detectar duplicidade
- ordenar elementos

---

## 🙋‍♂️ HashSet

### 🔍 Como funciona

- Baseado em tabela hash
- Não garante ordem de inserção
- Utiliza os métodos:
  - hashCode()
  - equals()

### ⚠️ Regra importante

**Para que o HashSet funcione corretamente com objetos customizados, é obrigatório sobrescrever:**

- equals()
- hashCode()

Caso contrário, a comparação será feita por **referência de memória.**


## 📌 Exemplo

```java
Set<Product> products = new HashSet<>();

products.add(new Product("Celular", 1200.0));
Product prod = new Product("Celular", 1200.0);

// Retorna false se equals() e hashCode() não forem implementados
System.out.println(products.contains(prod));
```


## 🙋‍♂️ TreeSet

### 🔍 Como funciona

- Mantém os elementos ordenados automaticamente
- Não permite duplicados (definidos pelo compareTo)
- Baseado em árvore balanceada

Utiliza:

- compareTo() (Comparable)
- ou Comparator

### ⚠️ Regra importante


Para usar `TreeSet`, a classe dos objetos deve implementar:

```java
Comparable<T>
```

Ou um `Comparator` deve ser fornecido.

## 📌 Exemplo

```java
Set<Product> products = new TreeSet<>();

products.add(new Product("TV", 900.0));
products.add(new Product("Celular", 1200.0));
products.add(new Product("Notebook", 500.0));
```

## 🧠 Comparação case-insensitive


```java
@Override
public int compareTo(Product other) {
    return name.toUpperCase().compareTo(other.getName().toUpperCase());
}
```

### O uso de toUpperCase() garante:

- ordenação alfabética consistente
- comparação **case-insensitive**
- previsibilidade no `TreeSet`

## ⚔️ HashSet vs TreeSet

| Característica        | HashSet                   | TreeSet                     |
| --------------------- | ------------------------- | --------------------------- |
| Ordenação             | ❌ Não mantém ordem        | ✔️ Ordenado automaticamente |
| Estrutura interna     | Tabela hash               | Árvore balanceada           |
| Verificação duplicata | `hashCode()` + `equals()` | `compareTo()`               |
| Desempenho            | 🚀 Mais rápido            | 🐢 Mais lento               |
| Requisito             | equals + hashCode         | Comparable ou Comparator    |


## 📌 Resumo

- `HashSet` é ideal quando desempenho é prioridade
- `TreeSet` é ideal quando ordenação é necessária

### Objetos customizados exigem:

- `equals()` + `hashCode()` → `HashSet`
- `compareTo()` → `TreeSet`
