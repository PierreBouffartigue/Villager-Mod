# Villager Mod

## Présentation

Le projet Villager est un mod Minecraft 1.12.2 visant à recréer un petit village géré par des IA que le joueur pourra
aider pour le faire grandir et se développer. Il devra également le défendre lors d'attaques de monstres.

## Fonctionnalités

WIP

## Installation client

Pour une installation normale du mod, il vous faudra :

    -   Un compte Minecraft

    -   Une installation de Minecraft officielle

    -   Forge 1.12.2 pour pouvoir charger le mod (Prendre installer puis installer sur le client après l'avoir lancé : http://files.minecraftforge.net/maven/net/minecraftforge/forge/index_1.12.2.html)

    -   Le mod Villager qui sera à mettre dans le dossier mods du .minecraft accessible en ouvrant un powershell ou CMD et en tapant %appdata%

## Installation développeur

    Java :

    - Installez le SDK de Java 8 (https://www.oracle.com/fr/java/technologies/javase-downloads.html)

    - Dans les variables système de votre ordinateur ajoutez en variable `JAVA_HOME` et en valeur le chemin vers votre JDK Java 8

    - Dans les variables utilisateurs modifiez le path et ajoutez le lien vers le bin de votre JDK Java 8
    
    Forge : 

    - Télécharger http://adfoc.us/serve/?id=27122872518016 

    - Décompressez le dossier et ouvrez un powershell à la racine du dossier

    - Effectuez dans l'ordre les commandes `.\gradlew setupDecompWorkspace`, `.\gradlew eclipse`

    - Une fois terminé, glissez le contenu du repo Git dans ce dossier

    - Ouvrez ce dossier avec votre IDE en tant que projet Eclipse ou Gradle (IntelliJ fortement recommandé)

    IDE :

    - L'environnement est désormais fonctionnelle et devrait vous télécharger les dépendances du gradle

    - Le plugin Minecraft sous IntelliJ peut vous être proposé et vous devrez le télécharger.

    - Pour pouvoir lancer Minecraft directement depuis l'IDE il faudra ajouter une configuration gradle avec comme task `runClient`
    
    - Pour pouvoir exporter le mod il faudra le build hors IDE, en allant à la racine du projet et en utilisant `.\gradlew build`

## Capture d'écran

