from flask import Flask
from flask_sqlalchemy import SQLAlchemy
import os

app = Flask(__name__)
caminho = os.path.dirname(os.path.abspath(__file__))
arquivobd = os.path.join(caminho, 'dados.db')
app.config['SQLALCHEMY_DATABASE_URI'] = "sqlite:///" + arquivobd

db = SQLAlchemy(app)

class Pessoa(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    nome = db.Column(db.String(70), nullable=False)
    dataNascimento = db.Column(db.String(80))
    cidadeOrigem = db.Column(db.String(80))

class Usuario(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    pessoa_id = db.Column(db.Integer, db.ForeignKey('pessoa.id'))
    matricula = db.Column(db.String(50))


with app.app_context():
    db.create_all()

    def incluir():
        p = Pessoa(nome="Felipe", dataNascimento="29/8", cidadeOrigem="Natal")
        usuario = Usuario(pessoa_id=p.id, matricula="45547")
        db.session.add(usuario)
        db.session.commit()
    def deletar():
        usuario = Usuario.query.filter_by(id="7").first()
        db.session.delete(usuario)
        db.session.commit()
    def consultarUsuarios():
        usuarios = Usuario.query.all()
        return usuarios
    def consultarFiltro():
        usuarios = Usuario.query.filter_by(matricula="45547").all()
        for usuario in usuarios:
            print (usuario.matricula)
    
    incluir()
    incluir()
    usuarios=consultarUsuarios()
    for usuario in usuarios:
        print(f"ID: {usuario.id}, Matrícula: {usuario.matricula}")

