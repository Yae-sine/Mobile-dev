 import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget{
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title : 'Mini To-Do List',
      theme : ThemeData(primarySwatch: Colors.blue),
      home : TodoListScreen(),
    );
  }
}

class TodoListScreen extends StatefulWidget{
  const TodoListScreen({super.key});

  @override
  State<TodoListScreen> createState() => _TodoListScreenState();
}

class _TodoListScreenState extends State<TodoListScreen> {
  final TextEditingController _controller = TextEditingController();
  final List<String> _tasks = [];

  void _addTask(){
    if(_controller.text.isNotEmpty){
      setState(() {
        _tasks.add(_controller.text);
        _controller.clear();
      });
    }
  }

  void _removeTask(int index){
    setState((){
      _tasks.removeAt(index);
    });
  }
  @override
  Widget build(BuildContext context){
    return Scaffold(
      appBar: AppBar(
        title : const Text("Mini To-Do List"),
        backgroundColor: Colors.blue,
      ),
      body : Padding(
        padding: const EdgeInsets.all(16.0),
        child : Column(
          children: [
            Row(
              children: [
                Expanded(
                    child: TextField(
                      controller: _controller,
                      decoration : const InputDecoration(
                        hintText : "Ecrire une Tache...",
                      ),
                  ),
                ),
                const SizedBox(width:  10),
                ElevatedButton(onPressed: _addTask, child:const Text("Ajouter"),
                ),
              ],
            ),
            const SizedBox(height : 20),
            Expanded(
                child: ListView.builder(
                  itemCount: _tasks.length,
                  itemBuilder: (context , index){
                    return ListTile(
                      title : Text(_tasks[index]),
                      leading:const Icon(Icons.check_circle_outline),
                      onTap:() => _removeTask(index),
                    );
                  },)
            )
          ],
        )
      )
    );
  }
}