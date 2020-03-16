#|/bin/bash
git checkout acme-stg
git pull origin acme-stg
git checkout acme-prd
git pull origin acme-prd
git merge acme-stg
git push
