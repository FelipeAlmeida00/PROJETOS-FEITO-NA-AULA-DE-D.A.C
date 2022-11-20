class CreateCustomers < ActiveRecord::Migration[7.0]
  def change
    create_table :customers do |t|
      t.string :nome
      t.string :sobrenome
      t.date :data_de_nascimento
      t.string :email
      t.text :observacao

      t.timestamps
    end
  end
end
