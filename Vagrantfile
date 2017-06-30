# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure("2") do |config|
  config.vm.box = "comma/spark"
  #config.vm.box_download_ca_cert = "../shared_folder/keys/HQSSL.pem"
  config.vm.provider "virtualbox" do |vb|
    vb.memory = "4096"
  end
  config.vm.boot_timeout = 30
  config.vm.network "forwarded_port", guest: 80, host: 80, host_ip: "127.0.0.1"
  config.vm.network "forwarded_port", guest: 3306, host: 13306, host_ip: "127.0.0.1"
  config.vm.network "forwarded_port", guest: 6379, host: 16379, host_ip: "127.0.0.1"
  config.vm.network "forwarded_port", guest: 27017, host: 27017, host_ip: "127.0.0.1"
end
