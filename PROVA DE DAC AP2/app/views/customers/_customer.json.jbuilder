json.extract! customer, :id, :nome, :sobrenome, :data_de_nascimento, :email, :observacao, :created_at, :updated_at
json.url customer_url(customer, format: :json)
