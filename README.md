# CompteurAndroid - TP Android Studio

Ce projet constitue la réalisation du premier TP Android Studio : **Réalisation d'une application compteur**.

---

## 📌 Présentation du projet
L'application affiche un compteur entier dynamique permettant à l'utilisateur d'incrémenter, décrémenter et réinitialiser sa valeur à l'aide de boutons.

- **Langage** : Kotlin
- **SDK Minimal** : Android 7.0 (API 24)
- **SDK Cible** : Android 14 (API 34)
- **Architecture** : Single Activity (Empty Views Activity)

---

## 🚀 Fonctionnalités implémentées

### Fonctionnalités de base
1. **Affichage du compteur** avec un texte de grande taille (`72sp`), centré dans une carte Material Design.
2. **Bouton `+`** (`buttonIncrementer`) : incrémente le compteur de 1.
3. **Bouton `-`** (`buttonDecrementer`) : décrémente le compteur de 1 (gère les nombres négatifs).
4. **Bouton `Réinitialiser`** (`buttonReinitialiser`) : remet la valeur du compteur à 0.
5. **Gestion stricte des ressources** : tous les textes visibles proviennent de `res/values/strings.xml`.

### Améliorations facultatives intégrées
- **Indication visuelle par couleur** :
  - 🟢 **Vert** lorsque le compteur est positif (> 0).
  - 🔴 **Rouge** lorsque le compteur est négatif (< 0).
  - ⚫ **Noir / Neutre** lorsque le compteur est égal à 0.
- **Boutons rapides `+5` et `-5`** pour modifier la valeur par palier.
- **Message Toast** lors de la réinitialisation confirmant l'action à l'utilisateur.
- **Conservation d'état à la rotation de l'écran** via `onSaveInstanceState` et `onRestoreInstanceState`.

---

## 🧪 Tests de validation effectués

| Action de l'utilisateur | Résultat attendu | Résultat obtenu | Statut |
| :--- | :---: | :---: | :---: |
| Démarrage de l'application | Compteur affiche `0` (noir) | `0` (noir) | ✅ Validé |
| Clic sur `+` | Compteur affiche `1` (vert) | `1` (vert) | ✅ Validé |
| Deuxième clic sur `+` | Compteur affiche `2` (vert) | `2` (vert) | ✅ Validé |
| Clic sur `-` | Compteur affiche `1` (vert) | `1` (vert) | ✅ Validé |
| Deux clics sur `-` | Compteur affiche `-1` (rouge) | `-1` (rouge) | ✅ Validé |
| Clic sur `+5` | Compteur passe de `-1` à `4` | `4` (vert) | ✅ Validé |
| Clic sur `Réinitialiser` | Compteur à `0` + Toast | `0` + Toast affiché | ✅ Validé |
| Rotation de l'écran (Portrait -> Paysage) | Maintien de la valeur courante | Valeur conservée | ✅ Validé |

---

## 📝 Compte rendu des difficultés rencontrées

1. **Perte de la valeur lors de la rotation de l'écran** :
   - *Difficulté* : Par défaut, lors d'une rotation d'écran, Android détruit et recrée l'activité, ce qui réinitialisait la variable `compteur` à 0.
   - *Solution* : Implémentation du cycle de vie avec `onSaveInstanceState(outState: Bundle)` pour stocker la valeur sous la clé `KEY_COMPTEUR` et réinjection dans `onCreate` / `onRestoreInstanceState`.

2. **Application des bonnes couleurs selon le thème système** :
   - *Difficulté* : L'accès direct aux couleurs pouvait poser des avertissements de compatibilité ou ne pas respecter le contraste.
   - *Solution* : Utilisation de `ContextCompat.getColor(this, R.color.color_xxx)` et définition des codes hexadécimaux dans `colors.xml`.

---

## 📂 Structure des fichiers principaux
- `app/src/main/java/com/example/compteurandroid/MainActivity.kt` : Code source Kotlin
- `app/src/main/res/layout/activity_main.xml` : Mise en page XML avec ConstraintLayout
- `app/src/main/res/values/strings.xml` : Chaînes de caractères localisées
- `app/src/main/res/values/colors.xml` : Palette de couleurs (positif, négatif, neutre)
