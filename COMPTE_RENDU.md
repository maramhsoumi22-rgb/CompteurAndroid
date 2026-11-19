# Compte Rendu - TP Android : Application Compteur

**Étudiant** : Maram Hsoumi  
**Module** : Développement Mobile Android (Kotlin)  
**Projet** : CompteurAndroid  

---

## 1. Objectifs du TP
- Découverte de l'environnement Android Studio et configuration d'un projet Kotlin.
- Création d'une interface utilisateur basée sur `ConstraintLayout`, `TextView` et `Button`.
- Gestion des interactions utilisateur et écouteurs d'événements `setOnClickListener`.
- Manipulation des variables d'état et mise à jour dynamique des vues graphiques.

---

## 2. Architecture et Réalisation
L'application est architecturée autour d'une activité unique `MainActivity` :
- Les identifiants des composants sont conformes aux spécifications (`textViewCompteur`, `buttonIncrementer`, `buttonDecrementer`, `buttonReinitialiser`).
- La variable `compteur` est protégée et typée en entier (`Int`).
- L'affichage est centralisé dans la méthode `actualiserAffichage()` garantissant la synchronisation de l'UI avec l'état de la variable.

---

## 3. Améliorations facultatives réalisées
1. **Gestion colorimétrique selon le signe** :
   - Positif : Vert (`#2E7D32`)
   - Négatif : Rouge (`#C62828`)
   - Nul : Noir/Gris (`#212121`)
2. **Ajout de boutons d'incrémentation rapide** : Boutons `+5` et `-5` pour faciliter les variations importantes.
3. **Notification Toast** : Affichage d'un retour utilisateur au moment du reset.
4. **Gestion du cycle de vie (Rotation)** : Sauvegarde dans le bundle d'état pour éviter la perte de données lors du basculement d'orientation.

---

## 4. Bilan des tests
Tous les cas d'usage imposés par le barème ont été testés avec succès, incluant les valeurs négatives, le retour à zéro et les clics consécutifs rapides. Aucune anomalie ou fermeture inattendue (ANR / Crash) n'a été constatée.
