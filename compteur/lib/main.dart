import 'package:flutter/material.dart';

void main(){
  runApp(const MiniQuizApp());
}

class MiniQuizApp extends StatelessWidget{
  const MiniQuizApp({super.key});

  @override
  Widget build(BuildContext context){
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home : QuizPage(),
    );
  }
}

class QuizPage extends StatefulWidget{
  @override
  _QuizPageState createState() => _QuizPageState();
}

class _QuizPageState extends State<QuizPage> {
  String _messageResultat = "";
  Color _couleurMessage = Colors.black;

  void _verifierReponse(bool estCorrect) {
    setState(() {
      if (estCorrect) {
        _messageResultat = "Bonne reponse !";
        _couleurMessage = Colors.green;
      }
      else {
        _messageResultat = "Mauvaise reponse!";
        _couleurMessage = Colors.red;
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Mini Quiz"),
        backgroundColor: Colors.blue,
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            const Text(
              "Quelle est la capitale du Maroc ?",
              style: TextStyle(
                fontSize: 22,
                fontWeight: FontWeight.bold,
                color: Colors.indigo,
              ),
              textAlign: TextAlign.center,
            ),
            const SizedBox(height: 30),
            SizedBox(
              width: 200,
              child: ElevatedButton(onPressed: () => _verifierReponse(true),
                child: const Text("Rabat"),
              ),
            ),
            const SizedBox(height :10),
            SizedBox(
              width: 200,
              child: ElevatedButton(onPressed: () => _verifierReponse(false),
                  child: const Text("Casablanca")),
            ),
            const SizedBox(height :10),
            SizedBox(
              width: 200,
              child: ElevatedButton(onPressed: () => _verifierReponse(false),
                child: const Text("Marrakech"),
              ),
            ),
           const SizedBox(height :10),
            const SizedBox(height: 40),
            Text(
              _messageResultat,
              style: TextStyle(
                fontSize: 20,
                fontWeight: FontWeight.bold,
                color: _couleurMessage,
              ),
            ),
          ],
        ),
      ),
    );

  }
}