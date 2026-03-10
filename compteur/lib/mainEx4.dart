/*

import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      debugShowCheckedModeBanner: false,
      home: CounterPage(),
    );
  }
}

class CounterPage extends StatefulWidget {
  const CounterPage({super.key});

  @override
  State<CounterPage> createState() => _CounterPageState();
}

class _CounterPageState extends State<CounterPage> {
  int _counter = 0;

  void _incrementCounter() {
    setState(() {
      _counter++;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Exercice 4 Flutter"),
        backgroundColor: Colors.blue,
        foregroundColor: Colors.white, // Pour que le texte soit lisible sur le bleu
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            // 2. Texte avec le nombre de clics en gras
            Text(
              'Nombre de clics : $_counter',
              style: const TextStyle(
                fontSize: 20,
                fontWeight: FontWeight.bold, // Texte en gras
              ),
            ),
            const SizedBox(height: 20),
            // 2. Bouton "Cliquer ici" en bleu
            ElevatedButton(
              onPressed: _incrementCounter,
              style: ElevatedButton.styleFrom(
                backgroundColor: Colors.blue,
                foregroundColor: Colors.white,
              ),
              child: const Text("Cliquer ici"),
            ),
          ],
        ),
      ),
    );
  }
}
*/
